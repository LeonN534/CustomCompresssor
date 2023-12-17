
package comprimirAlgoritmo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.xerial.snappy.SnappyOutputStream;

public class Algoritmo {
    public static void comprimirArchivoDeflate(File archivoOrigen, String customExtension) throws IOException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".deflate" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .deflate o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        DeflaterOutputStream deflateOut = new DeflaterOutputStream(fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            deflateOut.write(bytes, 0, length);
        }

        deflateOut.close();
        fis.close();
        fos.close();
    }
    
    public static void comprimirArchivoGZIP(File archivoOrigen, String customExtension) throws IOException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".gz" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .gz o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        GZIPOutputStream gzipOut = new GZIPOutputStream(fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            gzipOut.write(bytes, 0, length);
        }

        gzipOut.close();
        fis.close();
        fos.close();
    }
    
    public static void comprimirArchivoBzip2(File archivoOrigen, String customExtension) throws IOException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".bz2" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .bz2 o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        BZip2CompressorOutputStream bzip2Out = new BZip2CompressorOutputStream(fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            bzip2Out.write(bytes, 0, length);
        }

        bzip2Out.close();
        fis.close();
        fos.close();
    }
    
    public static void comprimirArchivoLZ4(File archivoOrigen, String customExtension) throws IOException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".lz4" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .lz4 o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        LZ4BlockOutputStream lz4Out = new LZ4BlockOutputStream(fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            lz4Out.write(bytes, 0, length);
        }

        lz4Out.close();
        fis.close();
        fos.close();
    }
    
    public static void comprimirArchivoSnappy(File archivoOrigen, String customExtension) throws IOException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".snappy" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .snappy o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        SnappyOutputStream snappyOut = new SnappyOutputStream(fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            snappyOut.write(bytes, 0, length);
        }

        snappyOut.close();
        fis.close();
        fos.close();
    }
    
    public static void comprimirArchivoLZMA(File archivoOrigen, String customExtension) throws IOException, CompressorException {
        String nombreArchivo = archivoOrigen.getName();
        String carpetaOrigen = archivoOrigen.getParent();

        FileInputStream fis = new FileInputStream(archivoOrigen);

        // Verificar si customExtension está vacío
        String extension = customExtension.isEmpty() ? ".xz" : "." + customExtension;

        // Cambiar el nombre del archivo comprimido a .xz o .<customExtension>
        FileOutputStream fos = new FileOutputStream(carpetaOrigen + File.separator + nombreArchivo + extension);
        CompressorOutputStream lzmaOut = new CompressorStreamFactory().createCompressorOutputStream(CompressorStreamFactory.LZMA, fos);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            lzmaOut.write(bytes, 0, length);
        }

        lzmaOut.close();
        fis.close();
        fos.close();
    }
}
