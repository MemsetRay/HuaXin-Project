package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Notice;

import java.util.List;


public interface NoticeMapper {
        /**
         * 查询全部公告信息
         * @return
         */
        List<Notice>SelectAll();

        /**
         * 按id号查询公告信息
         * @param id
         * @return
         */
        Notice SelectById( int id);

        /**
         * 更新公告信息
         * @param notice
         * @return
         */
        int Update(Notice notice);

        /**
         * 插入一个公告信息
         * @param notice
         * @return
         */
        int Insert(Notice notice);

        /**
         * 删除公告信息
         * @param notice
         * @return
         */
        int Delete(Notice notice);
}
