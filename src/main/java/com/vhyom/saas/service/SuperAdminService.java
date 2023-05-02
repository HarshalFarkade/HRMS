package com.vhyom.saas.service;

import com.vhyom.saas.entity.VssSuperAdmin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SuperAdminService {

    String createSuperAdmin(VssSuperAdmin vssSuperAdmin, MultipartFile file,String  path) throws IOException;

    List<Object[]> getAllsuperAdminBySortedFirstNameAsc(String firstName);

    List<Object[]>getAllsuperAdminByUuid(String uuid,String firstName);

    String deletesuperAdminByuuid(String uuid,VssSuperAdmin vssSuperAdmin);

    String updateSuperAdminByuuid(String uuid,VssSuperAdmin vssSuperAdmin,MultipartFile file, String path) throws IOException;

    public VssSuperAdmin getUserByEmailAndPassword(String emailId,String password) throws Exception;
}
