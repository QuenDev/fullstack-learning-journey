# Week 1 - Git Fundamentals

✅ **Git Module — OFFICIALLY DONE!**

## Core Git Commands

✅ git init              → initialize repo                                
✅ git config            → setup identity
✅ git status / -s       → check state
✅ git add               → stage changes
✅ git commit            → save snapshot
✅ git commit -a         → skip staging
✅ git diff              → see changes
✅ git log / --oneline   → view history
✅ git rm                → remove files
✅ git mv                → move/rename files
✅ git branch            → manage branches
✅ git checkout -b       → create + switch branch
✅ git merge             → combine branches
✅ git reset             → undo commits
✅ git clone             → copy remote repo

## Remote Repository Commands

✅ git fetch             → download changes without merging
✅ git pull              → download AND merge changes (fetch + merge)
✅ git push              → send commits to GitHub
✅ git push -u origin [branch]  → push new branch to GitHub
✅ git remote -v         → see all remote connections

## Workflow Example

```bash
git checkout -b feature-login    # create branch
# write code...
git add .                        # stage
git commit -m "added login"      # commit
git push -u origin feature-login # push to GitHub
# create Pull Request on GitHub
# get reviewed and approved
# merge to master ✅
```