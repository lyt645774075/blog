package com.freturn.tech.support.domainObj.transfer;

import com.freturn.tech.biz.domain.Comment;
import com.freturn.tech.dal.dataobject.CommentDO;
import com.freturn.tech.support.constant.CommentType;
import com.freturn.tech.support.constant.Device;
import com.freturn.tech.support.constant.DomainType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: CommentTransfer, v 0.1 2016-05-09 19:14 yangtao.lyt Exp $
 */
public class CommentTransfer {

    public static Comment toBO(CommentDO commentDO){

        Preconditions.checkNotNull(commentDO);

        Comment comment = new Comment();
        comment.setId(commentDO.getId());
        comment.setGmtCreate(commentDO.getGmtCreate());
        comment.setGmtModified(commentDO.getGmtModified());
        comment.setDomainId(commentDO.getDomainId());
        comment.setDomainName(commentDO.getDomainName());
        comment.setDomainType(DomainType.getTypeByCode(commentDO.getDomainType()));
        comment.setUserId(comment.getUserId());
        comment.setUserNickName(comment.getUserNickName());
        comment.setType(CommentType.getTypeByCode(commentDO.getType()));
        comment.setContent(commentDO.getContent());
        comment.setParentId(commentDO.getParentId());
        comment.setCreatorId(commentDO.getCreatorId());
        comment.setCreatorNickName(commentDO.getCreatorNickName());
        comment.setCreatorIconUrl(commentDO.getCreatorIconUrl());
        comment.setDevice(Device.getTypeByCode(commentDO.getDevice()));
        comment.setLocation(commentDO.getLocation());

        return comment;

    }


    public static List<Comment> toBOList(List<CommentDO> commentDOList){
        if(CollectionUtils.isEmpty(commentDOList)){
            return Lists.newArrayList();
        }

        List<Comment> result = Lists.newArrayList();
        for(CommentDO commentDO : commentDOList){
            result.add(toBO(commentDO));
        }

        return result;
    }

}
