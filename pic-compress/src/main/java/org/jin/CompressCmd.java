package org.jin;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Mojo(name = "compress")
public class CompressCmd extends AbstractMojo {

    @Parameter
    private String inputPath;

    @Parameter
    private String outputPath;
    @Parameter(defaultValue = "jpg")
    private String format;
    @Parameter(defaultValue = "0.5")
    private Double scale;


    public void execute() throws MojoExecutionException, MojoFailureException {

        File file = new File(inputPath);
        if(!(file.exists()&&file.isDirectory())){
            throw new RuntimeException("'inputPath' should be valid.");
        }
        File[] files = file.listFiles();
        File des = new File(outputPath);
        if(!des.exists()){
            boolean mkdirs = des.mkdirs();
            if(mkdirs){
                getLog().info("'outputPath not exist, created.");
            }
        }
        if(!des.isDirectory()){
            throw new RuntimeException("'outputPath' should be valid.");
        }
        try {
            Thumbnails.of(files)
                    .scale(scale)
                    .outputFormat(format)
                    .toFiles(des, Rename.NO_CHANGE);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        getLog().info("success!");
    }
}
