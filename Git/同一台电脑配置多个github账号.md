## SSH Key 配置
- 打开 Git Bash。
- 创建 SSH Key
`$ ssh-keygen -t rsa -C "注册邮箱"`
这将使用提供的电子邮件作为标签创建一个新的 SSH 密钥。
    - 当系统提示您“输入要在其中保存密钥的文件”时，按 Enter。这接受默认文件位置。
        ```
        > Enter a file in which to save the key (/c/Users/you/.ssh/id_algorithm):[Press enter]
        ```
    - 在提示符处，键入安全密码 回车跳过可以
        ```
        > Enter passphrase (empty for no passphrase):[Press enter]
        ```

在用户主目录 /.ssh/ 下会生成有两个文件，id_rsa 是私钥，id_rsa.pub 是公钥 ，或者自定义名称
 
3. 添加秘钥
如果已经安装 GitHub Desktop，无需处理SSH 密钥:

其他的：
1. 确保 ssh-agent 正在运行，或者手动启动它
    ```
    # start the ssh-agent in the background
    $ eval "$(ssh-agent -s)"
    > Agent pid 59566
    ```
2. 将秘钥添加到 ssh-agent,`id_ed25519` 替换为生成的私钥文件的名称。
    ```
    $ ssh-add ~/.ssh/id_ed25519
    ```



## 配置两个账号
按照上面生成两个秘钥信息
### 设置 **config**
然后再在户主目录 /.ssh/ 下添加一个`config`文件，然后添加如下配置

每个用户设置不同的 `Host`
```
# github 用户 a
Host a.github.com
HostName github.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/a_id_rsa

# github 用户 b
Host b.github.com
HostName github.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/b_id_rsa

```


### 验证
```
$ ssh -T git@a.github.com
Hi a! You've successfully authenticated, but GitHub does not provide shell access.

$ ssh -T git@b.github.com
Hi b!  You've successfully authenticated, but GitHub does not provide shell access.

```


###  重建 **remote** 在项目中使用，最重要的一步
删除原有的 remote，根据需要使用的用户，重新添加，例如在当前项目中使用**a**账号：
```
$ git remote rm origin
$ git remote add origin git@a.github.com:a/demo.git 
$ git push origin master
Everything up-to-date 
```
或者直接在 `.git/config`中修改
```
$ cd ~// 进入根目录
$ vim .git/config  

## 修改 github.com --> a.github.com 为我们指定的 `HOST`
[remote "origin"]
url = git@a.github.com:a/demo.git
fetch = +refs/heads/*:refs/remotes/origin/*
```

## ps:
1. 记得使用多账户的时候，取消git全局设置，在每个项目中设置使用的账号 
    方式一：
    ```
     1.取消global
    git config --global --unset user.name
    git config --global --unset user.email

    2.设置每个项目repo的自己的user.email
    git config  user.email "xxxx@xx.com"
    git config  user.name "a"
    ```
    方式二：直接编辑 `.git/config`
    ```
    $ cd ~// 进入根目录
    $ vim .git/config // 把 `name` 和 `email` 都改掉

    ```
2. 配置其他账号类同，如 gitee，gitlab 等等
