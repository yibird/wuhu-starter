package io.github.yibird.starter.extension.curd.core.controller;

import io.github.yibird.starter.extension.curd.core.annotation.CrudApi;
import io.github.yibird.starter.extension.curd.core.enums.Api;
import io.github.yibird.starter.extension.curd.core.model.resp.PageResp;
import io.github.yibird.starter.extension.curd.core.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Description 控制器抽象基类
 * @Author zchengfeng
 * @Datetime 2025/4/7 10:35
 */
public abstract class BaseController<S extends BaseService<P, Q, R>, P, Q, R> {

    @Autowired
    private S baseService;

    /**
     * 获取列表
     *
     * @return List<p>
     */
    @CrudApi(Api.List)
    @Operation(summary = "获取列表", description = "获取列表")
    @ResponseBody
    @GetMapping("/getList")
    public List<P> getList() {
        return baseService.getList();
    }

    /**
     * 分页获取列表
     *
     * @param query 查询对象
     * @return PageResp<P>
     */
    @CrudApi(Api.PageList)
    @Operation(summary = "分页获取列表", description = "分页获取列表")
    @ResponseBody
    @GetMapping("/getPageList")
    public PageResp<P> getPageList(@Validated Q query) {
        return baseService.getPageList(query);
    }

    /**
     * 根据id获取记录
     *
     * @param id id
     * @return P
     */
    @CrudApi(Api.GET)
    @Operation(summary = "获取记录", description = "根据id获取记录")
    @Parameter(name = "id", description = "ID", example = "1", in = ParameterIn.QUERY)
    @ResponseBody
    @GetMapping("/getRecord")
    public P getRecord(@RequestParam(value = "id") Long id) {
        return baseService.getRecord(id);
    }

    /**
     * 创建
     *
     * @param req 创建请求参数
     * @return 返回布尔值表示是否创建成功
     */
    @CrudApi(Api.Create)
    @Operation(summary = "创建数据", description = "创建数据")
    @ResponseBody
    @PostMapping("/create")
    public boolean create(@Validated() @RequestBody R req) {
        return baseService.create(req);
    }

    /**
     * 修改
     *
     * @param req 修改请求参数
     * @return 返回布尔值表示是否修改成功
     */
    @CrudApi(Api.Update)
    @Operation(summary = "修改数据", description = "修改数据")
    @ResponseBody
    @PostMapping("/update")
    public boolean update(@Validated() @RequestBody R req) {
        return baseService.update(req);
    }

    /**
     * 批量删除
     *
     * @param id id
     * @return 返回布尔值表示是否删除成功
     */
    @CrudApi(Api.Del)
    @Operation(summary = "删除数据", description = "根据id删除数据")
    @ResponseBody
    @PostMapping("/del")
    public boolean del(@Validated() @RequestBody Long id) {
        return baseService.del(id);
    }

    /**
     * 批量删除
     *
     * @param ids id数组
     * @return 返回布尔值表示是否删除成功
     */
    @CrudApi(Api.BatchDel)
    @Operation(summary = "删除数据", description = "批量删除数据")
    @ResponseBody
    @PostMapping("/batchDel")
    public boolean batchDel(@Validated() @RequestBody Collection<Long> ids) {
        return baseService.batchDel(ids);
    }
}
