### 用途
当仓库过大，只需要拉取部分文件时候

### 操作过程

``` Shell
$ mkdir testdir  //创建一个空文件夹
$ cd testdir  
$ git init // 初始化空仓库
$ git remote add -f origin https://github.com/xxx/xxxx.git // 关联远程地址 
$ git config core.sparsecheckout true // 开启Sparse Checkout模式
$ echo "xxxdir" >> .git/info/sparse-checkout // 设置需Check Out的文件。路径结构直接从项目目录下开始
$ git pull origin master // Check Out   // 拉取文件，需要指定分支
```

