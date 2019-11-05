package com.meetup.revel.service;


import com.meetup.revel.dao.UserDao;
import com.meetup.revel.entity.User;
import com.meetup.revel.exception.runtime.frontend.detailed.FileUploadException;
import com.meetup.revel.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.meetup.revel.keys.Key.EXCEPTION_FILE_UPLOAD;


@Service
@PropertySource("classpath:links.properties")
@PropertySource("classpath:strings.properties")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StorageService {

    private final Environment env;

    private final AuthenticationFacade authenticationFacade;

    private final UserDao userDao;

    private Path rootLocation;

    public User store(MultipartFile file) {
        rootLocation = Paths.get(env.getProperty("profile.img.link"));
        User user = authenticationFacade.getAuthentication();
        String inFileFormat = "." + file.getOriginalFilename().split("\\.")[1];
        user.setImgPath(env.getProperty("remote.img.link") + user.getId() + inFileFormat);
        //user.setImgPath(rootLocation.resolve(user.getId() + inFileFormat).toAbsolutePath().toString());
        userDao.update(user);
        try {
            Files.deleteIfExists(rootLocation.resolve(user.getId() + inFileFormat));
            Files.copy(file.getInputStream(), rootLocation.resolve(user.getId() + inFileFormat));
            return user;
        } catch (Exception e) {
            throw new FileUploadException(String.format(env.getProperty(EXCEPTION_FILE_UPLOAD), file.getOriginalFilename()));
        }
    }

    public String wishItemImageStore(MultipartFile file) {
        rootLocation = Paths.get(env.getProperty("wish.local.img.link"));
        String inFileFormat = "." + file.getOriginalFilename().split("\\.")[1];
        try {
            long imageName = System.nanoTime();
            String imagePath = env.getProperty("wish.remote.img.link") + imageName + inFileFormat;
            Files.deleteIfExists(this.rootLocation.resolve(imageName + inFileFormat));
            Files.copy(file.getInputStream(), this.rootLocation.resolve(imageName + inFileFormat));
            return imagePath;
        } catch (Exception e) {
            throw new FileUploadException(String.format(env.getProperty(EXCEPTION_FILE_UPLOAD), file.getOriginalFilename()));
        }
    }

}
