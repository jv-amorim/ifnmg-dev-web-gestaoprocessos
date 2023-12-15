package br.edu.ifnmg.gestaoprocessos.domain.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifnmg.gestaoprocessos.domain.base.BaseEntity;
import br.edu.ifnmg.gestaoprocessos.domain.file.FileEntity;
import br.edu.ifnmg.gestaoprocessos.domain.posthistory.PostHistoryEntity;
import br.edu.ifnmg.gestaoprocessos.domain.postsocial.PostSocialEntity;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;

@Entity(name = "Post")
@Table(name = "post")
@NamedQuery(name = "findByCategory", query="select p from Post p where p.category = ?1")
public class PostEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PostCategoryEnum category;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "selectionprocessid")
    private SelectionProcessEntity process;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> attachments = new ArrayList<FileEntity>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostHistoryEntity> history = new ArrayList<PostHistoryEntity>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostSocialEntity> socialPosts = new ArrayList<PostSocialEntity>();

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public PostCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(PostCategoryEnum category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SelectionProcessEntity getProcess() {
        return process;
    }

    public void setProcess(SelectionProcessEntity process) {
        this.process = process;
    }

    public List<FileEntity> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<FileEntity> attachments) {
        this.attachments = attachments;
    }

    public List<PostHistoryEntity> getHistory() {
        return history;
    }

    public void setHistory(List<PostHistoryEntity> history) {
    	this.history = history;
    }

    public List<PostSocialEntity> getSocialPosts() {
        return socialPosts;
    }

    public void setSocialPosts(List<PostSocialEntity> socialPosts) {
        this.socialPosts = socialPosts;
    }
    //</editor-fold>

}
