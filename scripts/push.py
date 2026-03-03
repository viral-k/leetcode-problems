#!/usr/bin/env python3
"""
Auto-commit and push after adding/updating problems.
Generates commit message based on changed problem folders.

Usage:
    python scripts/push.py
"""

import subprocess
import re
import sys
from pathlib import Path

REPO_ROOT = Path(__file__).parent.parent
DIFFICULTIES = {"easy", "medium", "hard"}


def run_cmd(cmd: list[str], check: bool = True) -> str:
    """Run a shell command and return output."""
    result = subprocess.run(cmd, capture_output=True, text=True, cwd=REPO_ROOT)
    if check and result.returncode != 0:
        print(f"Error: {result.stderr}")
        sys.exit(1)
    return result.stdout.strip()


def get_changed_problems() -> dict:
    """Get list of added/modified problem folders from git status."""
    status = run_cmd(["git", "status", "--porcelain"])
    
    if not status:
        return {"added": [], "modified": [], "other": []}
    
    added = []
    modified = []
    other = []
    
    seen_folders = set()
    
    for line in status.split("\n"):
        if not line.strip():
            continue
        
        status_code = line[:2].strip()
        file_path = line[3:].strip()
        
        # Check if it's a problem file
        parts = Path(file_path).parts
        if len(parts) >= 2 and parts[0] in DIFFICULTIES:
            folder_name = parts[1]
            if folder_name in seen_folders:
                continue
            seen_folders.add(folder_name)
            
            # Parse problem number and name
            match = re.match(r"(\d+)-(.+)", folder_name)
            if match:
                number = match.group(1)
                slug = match.group(2)
                title = slug.replace("-", " ").title()
                difficulty = parts[0].capitalize()
                
                problem_info = {
                    "number": number,
                    "title": title,
                    "difficulty": difficulty,
                    "folder": f"{parts[0]}/{folder_name}"
                }
                
                if status_code in ("??", "A"):
                    added.append(problem_info)
                elif status_code in ("M", "MM", "AM"):
                    modified.append(problem_info)
                else:
                    modified.append(problem_info)
        else:
            other.append(file_path)
    
    return {"added": added, "modified": modified, "other": other}


def generate_commit_message(changes: dict) -> str:
    """Generate commit message based on changes."""
    added = changes["added"]
    modified = changes["modified"]
    other = changes["other"]
    
    parts = []
    
    # Added problems
    if len(added) == 1:
        p = added[0]
        parts.append(f"Add {p['number']}. {p['title']} ({p['difficulty']})")
    elif len(added) > 1:
        nums = ", ".join(p["number"] for p in added)
        parts.append(f"Add problems: {nums}")
    
    # Modified problems
    if len(modified) == 1:
        p = modified[0]
        parts.append(f"Update {p['number']}. {p['title']}")
    elif len(modified) > 1:
        nums = ", ".join(p["number"] for p in modified)
        parts.append(f"Update problems: {nums}")
    
    # Other changes
    if other and not parts:
        # Only other files changed
        if any("README" in f for f in other):
            parts.append("Update README")
        elif any("script" in f for f in other):
            parts.append("Update scripts")
        else:
            parts.append("Update repo")
    
    if not parts:
        return "Update"
    
    return "; ".join(parts)


def main():
    # Check for uncommitted changes
    status = run_cmd(["git", "status", "--porcelain"], check=False)
    if not status:
        print("Nothing to commit.")
        return
    
    print("Detected changes:")
    print(status)
    print()
    
    # Get changed problems
    changes = get_changed_problems()
    
    # Show what was detected
    if changes["added"]:
        print("New problems:")
        for p in changes["added"]:
            print(f"  + {p['number']}. {p['title']} ({p['difficulty']})")
    
    if changes["modified"]:
        print("Modified problems:")
        for p in changes["modified"]:
            print(f"  ~ {p['number']}. {p['title']}")
    
    if changes["other"]:
        print("Other files:")
        for f in changes["other"]:
            print(f"  * {f}")
    
    print()
    
    # Update README first
    print("Updating README...")
    run_cmd(["python", "scripts/update_readme.py"])
    print()
    
    # Generate commit message
    commit_msg = generate_commit_message(changes)
    print(f"Commit message: {commit_msg}")
    print()
    
    # Confirm
    confirm = input("Proceed with commit and push? [Y/n]: ").strip().lower()
    if confirm and confirm != "y":
        print("Aborted.")
        return
    
    # Stage all changes
    print("Staging changes...")
    run_cmd(["git", "add", "."])
    
    # Commit
    print("Committing...")
    run_cmd(["git", "commit", "-m", commit_msg])
    
    # Push
    print("Pushing...")
    result = subprocess.run(
        ["git", "push"], 
        capture_output=True, 
        text=True, 
        cwd=REPO_ROOT
    )
    
    if result.returncode != 0:
        print(f"Push failed: {result.stderr}")
        print("\nTry pushing manually: git push -u origin main")
        sys.exit(1)
    
    print()
    print("Done!")


if __name__ == "__main__":
    main()
