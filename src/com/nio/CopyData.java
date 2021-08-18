package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class CopyData {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Apps\\MyWorkspace\\eclipse\\Day1-JavaAdvanced\\NIO\\input.txt");
		ReadableByteChannel source = fileInputStream.getChannel();

		FileOutputStream fileOutputStream = new FileOutputStream(
				"C:\\Apps\\MyWorkspace\\eclipse\\Day1-JavaAdvanced\\NIO\\output.txt");

		WritableByteChannel destination = fileOutputStream.getChannel();

		copyData(source, destination);
	}

//	private static void copyData(ReadableByteChannel source, WritableByteChannel destination) throws IOException {
//
//		ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
//
//		while (source.read(buffer) != -1) {
//			buffer.flip();
//			while (buffer.hasRemaining()) {
//				destination.write(buffer);
//			}
//		}
//		buffer.clear();
//	}
	
	
	private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
		while (src.read(buffer) != -1) {
			buffer.flip();
			while (buffer.hasRemaining()) {
				dest.write(buffer);
			}
			buffer.clear(); 
		}
	}


}
