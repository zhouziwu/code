package com.zzw.parent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.parent.dao.ParentDao;
import com.zzw.parent.entity.ParentEntity;
import com.zzw.parent.service.IParentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.parent.service.impl
 * @since 2020/2/28
 */
@Service
@Transactional
public class ParentServiceImpl extends ServiceImpl<ParentDao, ParentEntity> implements IParentService {
}
