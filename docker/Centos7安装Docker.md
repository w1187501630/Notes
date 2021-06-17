<TOC>

<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

  - [CentOS7 安装docker记录](#centos7-安装docker记录)
- [1.安装](#1安装)
  - [1.1.检查内核版本](#11检查内核版本)
  - [1.2. 更新yum](#12-更新yum)
  - [1.3. 安装依赖](#13-安装依赖)
  - [1.4. 安装docker](#14-安装docker)
  - [1.5. 安装完成检查docker版本](#15-安装完成检查docker版本)
  - [1.6. 设置开机自启](#16-设置开机自启)
  - [1.7. 启动docker](#17-启动docker)
  - [1.8. 查看docker服务状态](#18-查看docker服务状态)
- [2. Docker操作](#2-docker操作)
  - [2.1 镜像操作：](#21-镜像操作)
  - [2.2 容器及其中应用的生命周期操作：](#22-容器及其中应用的生命周期操作)
  - [2.3 容器文件系统操作：](#23-容器文件系统操作)
  - [2.4 Volume操作：](#24-volume操作)
  - [2.5 网络操作：](#25-网络操作)
  - [2.6 Swarm 相关操作：](#26-swarm-相关操作)
  - [2.7 系统操作：](#27-系统操作)
  - [2.8 其他常用操作：](#28-其他常用操作)
- [3. Docker的配置](#3-docker的配置)
  - [3.1. 更改存储目录：](#31-更改存储目录)
  - [3.2. 查看启动容器的具体信息：](#32-查看启动容器的具体信息)
  - [3.3. 要获取所有容器名称及其IP地址](#33-要获取所有容器名称及其ip地址)
  - [3.4. 配置镜像加速器](#34-配置镜像加速器)
  - [3.5. 配置docker远程连接接端口](#35-配置docker远程连接接端口)

<!-- /code_chunk_output -->

#### CentOS7 安装docker记录
###  1.安装
####  1.1.检查内核版本

 ```
uname -a

RedHat/CentOS必须要6.6版本以上，或者7.x才能安装docker，建议在RedHat/CentOS 7上使用docker，因为RedHat/CentOS 7的内核升级到了kernel 3.10，对lxc容器支持更好
 ```

####  1.2. 更新yum 
```
yum update
```

####  1.3. 安装依赖
```
yum install -y yum-utils device-mapper-persistent-data lvm2
```

####  1.4. 安装docker
```
yum install docker -y
```

####  1.5. 安装完成检查docker版本
```
docker -v
Docker version 1.13.1, build 7d71120/1.13.1
```

####  1.6. 设置开机自启
```
systemctl enable docker
or
chkconfig docker on
```

####  1.7. 启动docker
```
systemctl start docker
or
service docker start
```

####  1.8. 查看docker服务状态
```
systemctl status docker
or
service docker status
```

###  2. Docker操作

#### 2.1 镜像操作：
```
    build     Build an image from a Dockerfile
    commit    Create a new image from a container's changes
    images    List images
    load      Load an image from a tar archive or STDIN
    pull      Pull an image or a repository from a registry
    push      Push an image or a repository to a registry
    rmi       Remove one or more images
    search    Search the Docker Hub for images
    tag       Tag an image into a repository
    save      Save one or more images to a tar archive
    history   显示某镜像的历史
    inspect   获取镜像的详细信息
```
#### 2.2 容器及其中应用的生命周期操作：
```
    create    创建一个容器
    kill      Kill one or more running containers
    inspect   Return low-level information on a container, image or task
    pause     Pause all processes within one or more containers
    ps        List containers
    rm        删除一个或者多个容器
    rename    Rename a container
    restart   Restart a container
    run       创建并启动一个容器
    start     启动一个处于停止状态的容器
    stats     显示容器实时的资源消耗信息
    stop      停止一个处于运行状态的容器
    top       Display the running processes of a container
    unpause   Unpause all processes within one or more containers
    update    Update configuration of one or more containers
    wait      Block until a container stops, then print its exit code
    attach    Attach to a running container
    exec      Run a command in a running container
    port      List port mappings or a specific mapping for the container
    logs      获取容器的日志
```
#### 2.3 容器文件系统操作：
```
    cp        Copy files/folders between a container and the local filesystem
    diff      Inspect changes on a container's filesystem
    export    Export a container's filesystem as a tar archive
    import    Import the contents from a tarball to create a filesystem image
    Docker registry 操作：
    login     Log in to a Docker registry.
    logout    Log out from a Docker registry.
```

#### 2.4 Volume操作：
```
    volume    Manage Docker volumes
```

#### 2.5 网络操作：
```
    network   Manage Docker networks
```

#### 2.6 Swarm 相关操作：
```
    swarm     Manage Docker Swarm
    service   Manage Docker services
    node      Manage Docker Swarm nodes
```

#### 2.7 系统操作：
```
    version   Show the Docker version information
    events    持续返回docker 事件
    info      显示Docker 主机系统范围内的信息
```
#### 2.8 其他常用操作：
```
# 查看运行中的容器
docker ps
# 查看所有容器
docker ps -a
# 退出容器
按Ctrl+D 即可退出当前容器【但退出后会停止容器】
# 退出不停止容器：
组合键：Ctrl+P+Q
# 启动容器
docker start 容器名或ID
# 进入容器
docker attach 容器名或ID
# 停止容器
docker stop 容器名或ID
# 暂停容器
docker pause 容器名或ID
#继续容器
docker unpause 容器名或ID
# 删除容器
docker rm 容器名或ID
# 删除全部容器--慎用
docker stop $(docker ps -q) & docker rm $(docker ps -aq)
#保存容器，生成镜像
docker commit 容器ID 镜像名称
#从 host 拷贝文件到 container 里面
docker cp /home/soft centos:/webapp

```

###  3. Docker的配置
####  3.1. 更改存储目录：
```
#复制docker存储目录
     /var/lib/docker/. /home/docker

#更改 docker 存储文件目录
ln -s  /home/docker  /var/lib/docker
```


####  3.2. 查看启动容器的具体信息：
```
docker inspect <container_id>
```

####  3.3. 要获取所有容器名称及其IP地址
```
docker inspect -f '{{.Name}} - {{.NetworkSettings.IPAddress }}' $(docker ps -aq)

docker inspect --format='{{.Name}} - {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' $(docker ps -aq)

```


####  3.4. 配置镜像加速器
```
针对Docker客户端版本大于 1.10.0 的用户
您可以通过修改daemon配置文件/etc/docker/daemon.json来使用加速器

sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["<your accelerate address>"]
}
EOF
sudo systemctl daemon-reload
sudo systemctl restart docker

```

####  3.5. 配置docker远程连接端口
```
vi /usr/lib/systemd/system/docker.service

> 修改以ExecStart开头的行（centos 7）：

ExecStart=/usr/bin/dockerd   -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock
```

修改后保存文件，然后重启docker
```
systemctl daemon-reload
service docker restart
```
测试连接
```
curl http://localhost:2375/version
```
存在返回信息 就成功了
```
{"Version":"1.13.1","ApiVersion":"1.26","MinAPIVersion":"1.12","GitCommit":"7d71120/1.13.1","GoVersion":"go1.10.3","Os":"linux","Arch":"amd64","KernelVersion":"3.10.0-957.el7.x86_64","BuildTime":"2021-04-28T13:37:12.516442430+00:00","PkgVersion":"docker-1.13.1-205.git7d71120.el7.centos.x86_64"}
```
> ps 外部访问 可能不需要开启端口或者直接关闭防火墙
