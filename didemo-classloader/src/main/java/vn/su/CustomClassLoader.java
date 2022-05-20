package vn.su;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);

    }

    private byte[] loadClassFromFile(String fileName) {
        byte[] buffers = null;
        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(fileName.replace('.', File.separatorChar) + ".class");
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();){
            int nextValue = 0;
            while ((nextValue = inputStream.read()) != -1) {
                byteOutStream.write(nextValue);
            }
            buffers = byteOutStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffers;
    }
}
