package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.Dept;

import java.util.List;

public interface IDeptService {
    Res<List<Dept>> findAll();
}
