# Week 1 - Git Fundamentals

✅ **Git Module — OFFICIALLY DONE!**

## Core Git Commands

**Setup & Status:**
- `git init` — initialize a new repo in current folder
- `git config` — setup your name/email identity
- `git status` or `git status -s` — see what's changed in your repo

**Staging & Committing:**
- `git add` — stage changes for commit
- `git commit` — save a snapshot with a message
- `git commit -a` — skip staging, commit everything directly

**Viewing Changes:**
- `git diff` — see what changed (before staging)
- `git log` or `git log --oneline` — view commit history

**File Operations:**
- `git rm` — remove/delete files
- `git mv` — move or rename files

**Branches:**
- `git branch` — list or create branches
- `git checkout -b [name]` — create AND switch to new branch
- `git merge` — combine branches together

**Undoing & Copying:**
- `git reset` — undo commits (moves HEAD back)
- `git clone` — copy a remote repo to your machine

## Remote Repository Commands

**Syncing with GitHub:**
- `git fetch` — download changes from GitHub (doesn't merge)
- `git pull` — fetch AND merge in one command
- `git push` — upload your commits to GitHub
- `git push -u origin [branch]` — push a new branch to GitHub for the first time
- `git remote -v` — see all remote connections (URLs)

## Typical Workflow

```bash
git checkout -b feature-login    # create and switch to new branch
# write code...
git add .                        # stage all changes
git commit -m "added login"      # commit with message
git push -u origin feature-login # push new branch to GitHub
# create Pull Request on GitHub
# get reviewed and approved by team
# merge to master ✅
```