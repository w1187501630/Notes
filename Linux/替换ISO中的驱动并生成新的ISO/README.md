## 背景

在`Dell PowerEdge R740`服务器上安装`Fusion compute6.5.1` 时，`iso`系统无法识别`PERC H750`型号`RAID`控制器，导致扫描不到硬盘，系统安装失败。

## 解决办法

`FusionCompute 6.5.1\_CNA.iso`中的系统为`EulerOS V2.0SP5`

`EulerOS`是基于开源技术的开放的企业级`Linux`操作系统软件，以`Linux`稳定系统内核为基础。


## 实际操作步骤过程
找到一台已安装`Euler 2.0SP5`的机器，查看`/boot`目录获取其使用``Linux``内核版本信息

![](imgs/%E5%9B%BE%E7%89%871.png)

内核版本为：`3.10.0-862.14.1`

工作中使用最多的`Linux`系统为centos，查看`Linux`各版本及kernel的对应表，找到`3.10.0-862.14.1`内核对应的centos版本。


| Name | 对应内核源码包 |
| ---- | -------------- |
| 5.0/ | kernel-2.6.18-8.el5.src.rpm |
| 5.1/ | kernel-2.6.18-53.el5.src.rpm |
| 5.2/ | kernel-2.6.18-92.el5.src.rpm |
| 5.3/ | kernel-2.6.18-128.el5.src.rpm |
| 5.4/ | kernel-2.6.18-164.el5.src.rpm |
| 5.5/ | kernel-2.6.18-194.el5.src.rpm |
| 5.6/ | kernel-2.6.18-238.el5.src.rpm |
| 5.7/ | kernel-2.6.18-274.el5.src.rpm |
| 5.8/ | kernel-2.6.18-308.el5.src.rpm |
| 5.9/ | kernel-2.6.18-348.el5.src.rpm |
| 5.10/ | kernel-2.6.18-371.el5.src.rpm |
| 5.11/ | kernel-2.6.18-398.el5.src.rpm |
| 6.0/ | kernel-2.6.32-71.el6.src.rpm |
| 6.1/ | kernel-2.6.32-131.0.15.el6.src.rpm |
| 6.2/ | kernel-2.6.32-220.el6.src.rpm |
| 6.3/ | kernel-2.6.32-279.el6.src.rpm |
| 6.4/ | kernel-2.6.32-358.el6.src.rpm |
| 6.5/ | kernel-2.6.32-431.el6.src.rpm |
| 6.6/ | kernel-2.6.32-504.el6.src.rpm |
| 6.7/ | kernel-2.6.32-573.el6.src.rpm |
| 7.0.1406/ | kernel-3.10.0-123.el7.src.rpm |
| 7.1.1503/ | kernel-3.10.0-229.el7.src.rpm |
| 7.2.1511/ | kernel-3.10.0-327.el7.src.rpm |
| 7.3.1611/ | kernel-3.10.0-514.el7.src.rpm |
| 7.4.1708/ | kernel-3.10.0-693.el7.src.rpm |
| 7.5.1804/ | kernel-3.10.0-862.el7.src.rpm |
| 7.6.1810/ | kernel-3.10.0-957.el7.src.rpm |
| 7.7.1908/ | kernel-3.10.0-1062.el7.src.rpm |
| 7.8.2003/ | kernel-3.10.0-1127.el7.src.rpm |
| 7.9.2009/ | kernel-3.10.0-1160.el7.src.rpm |
| 8.0.1905/ | kernel-4.18.0-80.el8.src.rpm |
| 8.1.1911/ | kernel-4.18.0-147.el8.src.rpm |
| 8.2.2004/ | kernel-4.18.0-193.el8.src.rpm |
| 8.3.2011/ | kernel-4.18.0-240.el8.src.rpm |
| 8.4.2105/ | kernel-4.18.0-305.el8.src.rpm |


`Euler 2.0SP5` 与 `centos7.5` 使用相同的内核。

使用`Dell PowerEdge R740`安装` centos7.5 7.6 7.7`

`7.5 7.6`安装失败，无法识别`raid`控制器，`7.7`以上版本可正常识别`raid`控制器

登录`centos7.7`系统，查看`raid`控制器所使用的驱动

![](imgs/%E5%9B%BE%E7%89%872.png)

![](imgs/%E5%9B%BE%E7%89%873.png)

驱动名称为`megaraid_sas `识别出的设备型号为`1000：10e2`

下载`centos7.7`内核源码

![](imgs/%E5%9B%BE%E7%89%874.png)

[https://vault.centos.org/7.7.1908/updates/Source/SPackages/kernel-3.10.0-1062.18.1.el7.src.rpm](https://vault.centos.org/7.7.1908/updates/Source/SPackages/kernel-3.10.0-1062.18.1.el7.src.rpm)或

[http://ftp.pbone.net/mirror/vault.centos.org/7.7.1908/updates/Source/SPackages/kernel-3.10.0-1062.18.1.el7.src.rpm](http://ftp.pbone.net/mirror/vault.centos.org/7.7.1908/updates/Source/SPackages/kernel-3.10.0-1062.18.1.el7.src.rpm)

上传至`EulerOS`系统机器上并安装，安装之后源码相关文件位于`/root/rpmbuild/SOURCES ``Linux-3.10.0-1060.18.1.el7.tar.xz`

![](imgs/%E5%9B%BE%E7%89%875.png)

使用`xz`命令解压并使用`tar`解打包

驱动源码位于`drivers/scsi/megaraid`

![](imgs/%E5%9B%BE%E7%89%876.png)

![](imgs/%E5%9B%BE%E7%89%877.png)

此驱动支持`10e2`设备

接下来在`EulerOS`中编译源码

进入`drivers/scsi/megaraid`目录
```
make -C /usr/src/kernels/`3.10.0-862.14.1`.0.h209.eulerosv2r7.x86_64/ M=`pwd` modules
```
-C 需指定当前系统内核源代码目录，此处则需要指定`EulerOS`的源代码目录

如果无此目录，可以挂载`EulerOS`的`iso`作为本地`yum`源，安装

`kernel-devel-`3.10.0-862.14.1`.0.h209.eulerosv2r7.x86\_64` 编译需要`gcc`如果没有也需要安装

![](imgs/%E5%9B%BE%E7%89%878.png)

编译成功，`megaraid`目录生成的`megaraid_sas.ko`即为新的驱动文件

接下来需要替换原`fusion compute6.5.1 iso`中的驱动文件

上传`fusion compute6.5.1.iso`到`EulerOS`机器并挂载
```
mount -o loop -t iso9660 FusionCompute 6.5.1_CNA.iso /mnt
```
复制镜像文件到临时目录
```
rsync -a /mnt/ /temp
```

替换`boot/initrd`和`repo/OS.tar.gz`中的`megaraid_sas`驱动

![](imgs/%E5%9B%BE%E7%89%879.png)

![](imgs/%E5%9B%BE%E7%89%8710.png)

`Gzip`文件，需重命名为`initrd.gz`才能解压

创建临时目录`initrd-temp` 将`initrd.gz`解压到临时目录

![](imgs/%E5%9B%BE%E7%89%8711.png)

解压后`initrd`为`cpio`文件 继续解压 解压后删除`initrd`

![](imgs/%E5%9B%BE%E7%89%8712.png)

在当前目录查找驱动然后替换对应目录的文件

![](imgs/%E5%9B%BE%E7%89%8713.png)

替换完成后重新压缩`initrd`到原目录，然后删除临时目录
```
find . | cpio -o -H newc | gzip > ../initrd
``` 

接下来替换`repo/OS.tar.gz`中的驱动 将`OS.tar.gz`解压之后也是`initrd`文件，操作步骤同上，替换完之后将`initrd`和`Linux`重新打包为`OS.tar.gz`

打包完成后更新`sha256`
```
sha256sum OS.tar.gz OS.tar.gz.sha256
```


![](imgs/%E5%9B%BE%E7%89%8714.png)

最后在`temp` 目录 重新打包`iso`
```
mkisofs -quiet -b iso`Linux`/iso`Linux`.bin -c iso`Linux`/boot.cat -no-emul-boot -boot-load-size 4 -boot-info-table -eltorito-alt-boot -e EFI/BOOT/grubx64.efi -no-emul-boot -R -J -o /root/cna-custom.iso .
```