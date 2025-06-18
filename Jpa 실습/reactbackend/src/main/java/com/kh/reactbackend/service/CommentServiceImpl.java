package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.CommentDto;
import com.kh.reactbackend.entity.Comment;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Post;
import com.kh.reactbackend.repository.CommentRepository;
import com.kh.reactbackend.repository.MemberRepository;
import com.kh.reactbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    public final CommentRepository commentRepository;
    public final MemberRepository memberRepository;
    public final PostRepository postRepository;

    @Override
    public Comment createComment(CommentDto.Create createDto) {
        Member member = memberRepository.findMember(createDto.getMember_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = postRepository.getPost(createDto.getPost_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        Comment comment = createDto.toEntity();
        comment.changeMember(member);
        comment.changePost(post);
        commentRepository.save(comment);

        return comment;
    }

    @Override
    public List<CommentDto.Response> getCommentList(Long id) {
        List<Comment> comments = commentRepository.getComments(id);
        return comments.stream()
                .map(CommentDto.Response::toSimpleDto)
                .collect(Collectors.toList());
    }

}
