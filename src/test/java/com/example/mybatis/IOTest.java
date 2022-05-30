package com.example.mybatis;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.zip.ZipEntry;

@SpringBootTest
public class IOTest {

	@Test
	void context() throws IOException {
		Path rootDirectory = Paths.get("/home/albert", "coding/java/MyBatis-Plus-Example");
		Path tempDirectory = Files.createTempDirectory(rootDirectory, "temp");
		System.out.println("Temporary directory created successfully!");


	}

	@Test
	void con2() throws IOException {
		Path sql = Paths.get("", "sql");
		File file = sql.toFile();


	}

	@Test
	void compress() throws IOException {
		Path tempDirectory = Files.createTempDirectory(Paths.get(""), "temp");
		Path tempFile1 = Files.createTempFile(tempDirectory, "临时压缩包", ".zip");


	}


	@Test
	void comp2() throws IOException {
		Path sql = Paths.get("", "sql");
		Path archive = Files.createTempFile(Paths.get(""), "临时压缩包", ".zip");
		try (ZipArchiveOutputStream outputStream = new ZipArchiveOutputStream(archive)) {
			sql.forEach(s->{
				ZipArchiveEntry entry;
				try {
					entry = new ZipArchiveEntry("sql/init.sql");
					// 可以设置压缩等级
					outputStream.setLevel(5);
					// 可以设置压缩算法，当前支持ZipEntry.DEFLATED和ZipEntry.STORED两种
					outputStream.setMethod(ZipEntry.DEFLATED);
					// 也可以为每个文件设置压缩算法
					entry.setMethod(ZipEntry.DEFLATED);
					// 在zip中创建一个文件
					outputStream.putArchiveEntry(entry);
					// 完成一个文件的写入
					outputStream.closeArchiveEntry();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

			});




		}



	}

}
