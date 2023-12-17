
package descomprimirAlgoritmo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.swing.JFileChooser;
import net.jpountz.lz4.LZ4BlockInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.tukaani.xz.XZInputStream;
import org.xerial.snappy.SnappyInputStream;

public class Algoritmo {
    
    public static void descomprimirArchivoDeflate(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");
        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Obtener el nombre del archivo descomprimido basándonos en el nombre del archivo comprimido
            String nombreArchivoComprimido = new File(rutaArchivoComprimido).getName();
            String nombreArchivoDescomprimido = nombreArchivoComprimido.substring(0, nombreArchivoComprimido.lastIndexOf('.'));

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
                 InflaterInputStream inflaterInputStream = new InflaterInputStream(bufferedInputStream);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inflaterInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void descomprimirArchivoGZIP(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");

        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String nombreArchivoDescomprimido = "archivo_descomprimido.txt";  // Puedes cambiar esto si lo deseas
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 GZIPInputStream gzipInputStream = new GZIPInputStream(archivoEntrada);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = gzipInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void descomprimirArchivoBzip2(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");

        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String nombreArchivoDescomprimido = "archivo_descomprimido.txt";  // Puedes cambiar esto si lo deseas
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(archivoEntrada);
                 BZip2CompressorInputStream bzip2InputStream = new BZip2CompressorInputStream(bufferedInputStream);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bzip2InputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
    public static void descomprimirArchivoLZ4(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");

        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String nombreArchivoDescomprimido = "archivo_descomprimido.txt";  // Puedes cambiar esto si lo deseas
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 LZ4BlockInputStream lz4InputStream = new LZ4BlockInputStream(archivoEntrada);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = lz4InputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void descomprimirArchivoSnappy(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");

        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String nombreArchivoDescomprimido = "archivo_descomprimido.txt";  // Puedes cambiar esto si lo deseas
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 SnappyInputStream snappyInputStream = new SnappyInputStream(archivoEntrada);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = snappyInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   
    public static void descomprimirArchivoLZMA(String rutaArchivoComprimido) {
        // Crear un cuadro de diálogo de selección de destino
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar ruta para descomprimir el archivo");

        // Mostrar el cuadro de diálogo y obtener el resultado
        int resultado = fileChooser.showSaveDialog(null);

        // Verificar si el usuario seleccionó una ruta de destino
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta completa del directorio de destino
            String rutaDirectorioDestino = fileChooser.getSelectedFile().getAbsolutePath();

            // Concatenar el nombre del archivo descomprimido al directorio de destino
            String nombreArchivoDescomprimido = "archivo_descomprimido.txt";  // Puedes cambiar esto si lo deseas
            String rutaArchivoDescomprimido = rutaDirectorioDestino + File.separator + nombreArchivoDescomprimido;

            // Llamar al método para descomprimir
            try (FileInputStream archivoEntrada = new FileInputStream(rutaArchivoComprimido);
                 XZInputStream xzInputStream = new XZInputStream(archivoEntrada);
                 FileOutputStream archivoSalida = new FileOutputStream(rutaArchivoDescomprimido);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(archivoSalida)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = xzInputStream.read(buffer)) > 0) {
                    bufferedOutputStream.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
