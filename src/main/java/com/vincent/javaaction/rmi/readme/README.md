## Java远程方法调用（RMI [Remote Method Invocation]）

### 步骤一:制作远程接口
- 扩展java.rmi.Remote.Remote不具有方法，对于RMI来说只是一个记号接口.而接口扩展另一个接口用extends.
- 声明所有的方法都抛出RemoteException.因为底层用了网络和I/O，所以有发生异常的风险.
- 确定变量和返回值时属于原语（primitive）类型[基础类型和String和许多API内定的数组集合等类型]或者可序列化类型.

### 步骤二:制作远程实现
- 实现远程接口
- 扩展UnicastRemoteObject.为了成为远程服务对象，你的对象需要某些“远程的”功能，最简单的就是扩展java.rmi.server.UnicastRemoteObject,让超类帮你做这些工作.
- 设计一个不带变量的构造器，并抛出RemoteException.由于子类实例化的时候超类的构造器总会被调用.而UnicastRemoteObject的构造器都抛出了RemoteException异常.
- 用RMI Registry注册此服务.
    try{
        MyRemote service = new MyRemoteImpl();
        Naming.bind("rmi://xxx.xxx.xxx.xxx:xxxx[port]:RemoteHello[whatever name]", service)
        //Naming.rebind("rmi://xxx.xxx.xxx.xxx:xxxx[port]:RemoteHello[whatever name]", service)
    } catch(...)
    
### 步骤三:产生Stub和Skeleton [已不需要]
- 在远程实现类上执行rmic,命令:rmic MyRemoteImpl.  **现在已不需要生成骨架，而存根也已经动态生成给替换**

### 步骤四:执行remiregistry [已不需要]
- 命令:remiregistry.

### 步骤五:启动服务
- 命令:java MyRemoteImpl

### 步骤六:客户端接收
- 客户到RMI registry中寻找。 Naming.lookup("rmi://xxx.xxx.xxx.xxx:xxxx[port]:RemoteHello"）
- RMI registry返回Stub对象,强制转换.
- 调用stub方法，就像stub就是真正的服务对象一样