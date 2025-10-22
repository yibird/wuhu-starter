package io.github.yibird.starter.extension.curd.core.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import org.babyfish.jimmer.Page;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

/**
 * @Description 分页响应模型
 * @Author zchengfeng
 * @Datetime 2025/4/7 15:54
 */
@Schema(description = "分页响应模型")
public class PageResp<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "列表数据")
    private List<T> list;

    @Schema(description = "总记录条数", example = "10")
    private long total;

    @Schema(description = "总页码", example = "2")
    private long page;

    @Schema(description = "当前页码", example = "1")
    private int current;

    @Schema(description = "每页显示条数", example = "10")
    private int pageSize;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageResp(final List<T> list, long total, long page, int current, int pageSize) {
        this.list = list;
        this.total = total;
        this.page = page;
        this.current = current;
        this.pageSize = pageSize;
    }

    public static <T> PageResp<T> of(List<T> list, long total, long page, int current, int pageSize) {
        return new PageResp<>(list, total, page, current, pageSize);
    }

    public static <E, T> PageResp<T> wrap(Page<E> page, Function<Page<E>, List<T>> mapper, int current, int pageSize) {
        return PageResp.of(
                mapper.apply(page),
                page.getTotalRowCount(),
                page.getTotalPageCount(),
                current,
                pageSize
        );
    }
}
