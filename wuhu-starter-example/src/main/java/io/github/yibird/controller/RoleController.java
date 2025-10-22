package io.github.yibird.controller;

import io.github.yibird.model.query.RoleQuery;
import io.github.yibird.model.req.RoleReq;
import io.github.yibird.model.resp.RoleResp;
import io.github.yibird.service.RoleService;
import io.github.yibird.starter.extension.curd.core.annotation.CrudRequestMapping;
import io.github.yibird.starter.extension.curd.core.controller.BaseController;
import io.github.yibird.starter.extension.curd.core.enums.Api;

import io.github.yibird.starter.extension.curd.core.model.resp.PageResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/4/25 10:43
 */
@RestController
@CrudRequestMapping(value = "/sys/role", api = {Api.List, Api.PageList, Api.Import, Api.Export, Api.Update})
public class RoleController extends BaseController<RoleService, RoleResp, RoleQuery, RoleReq> {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/pageList")
    public PageResp<RoleResp> pageList() {
        RoleQuery query = new RoleQuery();
        query.setCurrent(1);
        query.setPageSize(10);
        return roleService.getPageList(query);
    }
}
