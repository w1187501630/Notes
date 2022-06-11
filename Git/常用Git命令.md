
## 清理无效的远程追踪分支

本地同步远程创建的分支，可以在本地创建远程追踪分支，
```bash
git remote update
```
但是 如果在远程版本库上删除了某一分支，该命令并不会删除本地的远程追踪分支，
需要：

```git
git remote prune origin --dry-run
```
清理无效的远程分支
```git
git remote prune origin
```
## git branch
```git
# 新建本地分支，但不切换
git branch <branch-name> 
# 查看本地分支
git branch
# 查看远程分支
git branch -r
# 查看本地和远程分支
git branch -a
# 删除本地分支
git branch -D <branch-nane>
# 重新命名分支
git branch -m <old-branch-name> <new-branch-name>

```
## git stash
```git
git stash //把本地的改动暂存起来
git stash save "message" 执行存储时，添加备注，方便查找。
git stash pop // 应用最近一次暂存的修改，并删除暂存的记录
git stash apply  // 应用某个存储,但不会把存储从存储列表中删除，默认使用第一个存储,即 stash@{0}，如果要使用其他个，git stash apply stash@{$num} 。
git stash list // 查看 stash 有哪些存储
git stash clear // 删除所有缓存的 stash

```

## git reset
```git
git reset --soft HEAD^  //软回溯，回退 commit 的同时保留修改内容
```

## Git 拉取pr到本地

```git
# PRId 为该 Pull Request 的序号，LocalBranchName为拉取到本地后的分支名称
git fetch origin pull/PRId/head:LocalBranchName

# 如果是fork的仓库
## 如果本地没有关联原仓库，则先关联一下
git remote add upstream <原仓库github地址>
 
### 查看仓库地址 
git remote -v 

### 拉取fork仓库的pr
git fetch upstream pull/PRId/head:LocalBranchName


```
