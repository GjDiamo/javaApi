# Java+web3j+contract交互

##### 1.新建java项目，引入 Maven 包

```
<dependency>
  <groupId>org.web3j</groupId>
  <artifactId>core</artifactId>
  <version>3.3.1</version>
</dependency>
```



##### 2.下载web3j并配置环境变量；

##### 3.下载solc;

##### 4. solc 编译生成 .bin .abi 文件

```\
solcjs Erc721.sol --bin --abi --optimize -o ./
```



##### 5.用 web3j 生成 java 封装器

```
web3j solidity generate --solidityTypes Compute_sol_Compute.bin Compute_sol_Compute.abi -o ./project/src/main/java -p com.demo
```

##### 6.将生成的文件导入到java中去；

```
我的是在utils下的Erc721_sol_ERC721。（跟我用 web3j 生成 java 封装器一模一样）
```

##### 7.导入UTC文件

```
UTC 开头的文件是在myEtherWallet 创建时自动生成的keystore文件；
```

##### 8.接下来得内容详看代码；

