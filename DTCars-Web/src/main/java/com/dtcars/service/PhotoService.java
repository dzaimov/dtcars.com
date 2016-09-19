package com.dtcars.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.apache.tomcat.util.codec.binary.Base64;
import com.dtcars.photo.Photo;
import com.dtcars.repository.JDBCRepository;

public class PhotoService {
	
	private JDBCRepository repo = new JDBCRepository();
	
	private final String filePath = "C:\\Users\\Todor\\Documents\\Project Images";
	
	public Photo createFromBase64WithHeader(String base64) throws IOException {
		
		if(base64.contains(",")) {
			String [] arr = base64.split(",");
			base64 = arr[1];
		}
		
		Photo photo = createFromBase64(base64);
		
		return photo;
	}
	
	private Photo createFromBase64( String photoBase64) throws IOException {
		
        String pathToStore = filePath + File.separator;

        Photo photo = storeImageBase64ToFileRepository( photoBase64, "jpeg", pathToStore);
        
        create(photo);
     
		return photo;
	} 
	
	private Photo storeImageBase64ToFileRepository(String base64, String format, String path) throws IOException{
		
		byte[] imageBodyContent = Base64.decodeBase64(base64);
		return storeImageToFileRepository(imageBodyContent, path);
		
	}
	    
	private Photo storeImageToFileRepository(final byte[] imageBodyContent, final String folderAbsolutePath)  throws IOException {
			
		String imageExtensionToStore = "jpeg";
		String uniqueImageName = UUID.randomUUID().toString(); // TODO - proverka za kolizii
			
		final String uniqueFileNameWithExtensionOriginal = uniqueImageName + "_o." + imageExtensionToStore;

		storeOptimizedImage(false, imageBodyContent, folderAbsolutePath, uniqueFileNameWithExtensionOriginal, false);

		BufferedImage image = ImageIO.read( new ByteArrayInputStream( imageBodyContent ) );
			
		return new Photo(uniqueImageName);
			
	}

	public byte[] storeOptimizedImage(boolean optimize, byte[] imageBinaryContent, String localFolderPathToStore,
			String fileName, boolean isThumbnail) throws IOException {

		String fullImagePath = localFolderPathToStore + fileName;
		Path path = Paths.get(fullImagePath);

		ensureFolderIsCreated(localFolderPathToStore);

		Files.write(path, imageBinaryContent, StandardOpenOption.CREATE_NEW);																		// be																			// unique
		return imageBinaryContent;
	}

    public void ensureFolderIsCreated( String folderName ){
        File folder = new File( folderName );
        if( folder.exists() ){
            if( !folder.isDirectory() )
                throw new IllegalArgumentException( "the provided directory is a file: " + folderName );
            else
                return; // just fine
        }
        // not exists
        folder.mkdirs();
    }
	
	private Photo create(Photo photo){
		
		repo.addPhoto(photo);
		
		return photo;
	} 
	
}
