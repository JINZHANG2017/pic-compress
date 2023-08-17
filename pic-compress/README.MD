# pic-compress 图片压缩maven插件
插件提供四个参数，引用方式如下：
```
<build>
    <plugins>
        <plugin>
            <groupId>org.jin</groupId>
            <artifactId>pic-compress</artifactId>
            <version>1.0-SNAPSHOT</version>
            <configuration>
                <inputPath>./src/main/resources/pic</inputPath>
                <outputPath>./src/main/resources/compressed</outputPath>
                <format>jpg</format>
                <scale>0.1</scale>
            </configuration>
        </plugin>
    </plugins>
</build>
```
# 参数说明
- inputPath: 原始图片路径
- outputPath: 压缩后的图片路径
- format: 生成的图片格式
- scale: 压缩比（压缩比越小生成的图片占用体积越小，但是也会越模糊）
# 运行方法
点击maven插件中的```pic-compress-maven-plugin:compress```即可运行
![maven_options.png](pic%2Fmaven_options.png)