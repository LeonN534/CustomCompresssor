
package verificacionAlgoritmo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import net.jpountz.lz4.LZ4BlockInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.xerial.snappy.SnappyInputStream;

public class Verificacion {
        
    public static boolean esDeflate(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             InflaterInputStream inflaterInputStream = new InflaterInputStream(bufferedInputStream)) {

            // Intenta leer datos del archivo comprimido con Deflate
            int bytesRead = inflaterInputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }
    
    public static boolean esGZIP(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             GZIPInputStream gzipInputStream = new GZIPInputStream(bufferedInputStream)) {

            // Intenta leer datos del archivo comprimido con GZIP
            int bytesRead = gzipInputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }
    
    public static boolean esBzip2(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             BZip2CompressorInputStream bzip2InputStream = new BZip2CompressorInputStream(bufferedInputStream)) {

            int bytesRead = bzip2InputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }

    public static boolean esLZ4(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             LZ4BlockInputStream lz4BlockInputStream = new LZ4BlockInputStream(bufferedInputStream)) {

            // Intenta leer datos del archivo comprimido con LZ4 (formato de bloque)
            int bytesRead = lz4BlockInputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }

    public static boolean esSnappy(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             SnappyInputStream snappyInputStream = new SnappyInputStream(bufferedInputStream)) {

            int bytesRead = snappyInputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }

    public static boolean esLZMA(String rutaArchivo) {
        try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivo);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
             LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(bufferedInputStream)) {

            int bytesRead = lzmaInputStream.read(new byte[1024]);
            return bytesRead != -1;

        } catch (IOException e) {
            return false;
        }
    }
}
