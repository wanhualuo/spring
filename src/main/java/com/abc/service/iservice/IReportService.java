package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportService {
    Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO);
}
