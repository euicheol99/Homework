package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Post;
import com.kh.reactbackend.repository.MemberRepository;
import com.kh.reactbackend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    public Post createPost(PostDto.Create createDto){
        Member member =memberRepository.findMember(createDto.getMember_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = createDto.toEntity();
        post.changeMember(member);
        postRepository.save(post);

        return post;
    }

    @Override
    public List<PostDto.Response> getPostList() {
        List<Post> posts = postRepository.getPosts();
        return posts.stream()
                .map(PostDto.Response::toSimpleDto) // Post → DTO 변환
                .collect(Collectors.toList());
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deletePost(id);
    }


    @Override
    public PostDto.Response getPost(Long id){
        Post post = postRepository.getPost(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return PostDto.Response.toSimpleDto(post);
    }

    @Override
    public Post updatePost(Long id, PostDto.Update updateDto) {
        Post post = postRepository.getPost(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        post.setPostTitle(updateDto.getPost_title());
        post.setStack(updateDto.getStack());
        post.setContent(updateDto.getContent());
        return post;
    }

}
