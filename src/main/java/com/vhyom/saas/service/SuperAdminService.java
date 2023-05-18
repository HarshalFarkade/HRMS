package com.vhyom.saas.service;

import com.vhyom.saas.dto.DashboardDto;
import com.vhyom.saas.dto.VssSuperAdmindto;
import com.vhyom.saas.entity.VssSuperAdmin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SuperAdminService {

    String createSuperAdmin(VssSuperAdmin vssSuperAdmin, String password,MultipartFile file,String  path) throws IOException;

    List<VssSuperAdmindto> getAllsuperAdmin();

    VssSuperAdmindto getSuperAdminByUuid(String uuid);

    String deletesuperAdminByuuid(String uuid,VssSuperAdmin vssSuperAdmin);

    String updateSuperAdminByuuid(String uuid,VssSuperAdmin vssSuperAdmin,String password ,MultipartFile file, String path) throws IOException;

    public VssSuperAdmin getUserByEmailAndPassword(String emailId,String password) throws Exception;

    List<DashboardDto> getDashboardData();


}
