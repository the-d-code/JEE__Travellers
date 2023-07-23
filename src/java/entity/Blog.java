/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Radhika Maniya
 */
@Entity
@Table(name = "blog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b"),
    @NamedQuery(name = "Blog.findByBlogID", query = "SELECT b FROM Blog b WHERE b.blogID = :blogID"),
    @NamedQuery(name = "Blog.findByBlogTitle", query = "SELECT b FROM Blog b WHERE b.blogTitle = :blogTitle"),
    @NamedQuery(name = "Blog.findByBlogImage", query = "SELECT b FROM Blog b WHERE b.blogImage = :blogImage"),
    @NamedQuery(name = "Blog.findByQuestions", query = "SELECT b FROM Blog b WHERE b.questions = :questions"),
    @NamedQuery(name = "Blog.findByAnswers", query = "SELECT b FROM Blog b WHERE b.answers = :answers"),
    @NamedQuery(name = "Blog.findByDescription", query = "SELECT b FROM Blog b WHERE b.description = :description")})
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BlogID")
    private Integer blogID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BlogTitle")
    private String blogTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BlogImage")
    private String blogImage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Questions")
    private String questions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Answers")
    private String answers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "Description")
    private String description;

    public Blog() {
    }

    public Blog(Integer blogID) {
        this.blogID = blogID;
    }

    public Blog(String blogTitle, String blogImage, String questions, String answers, String description) {
       
        this.blogTitle = blogTitle;
        this.blogImage = blogImage;
        this.questions = questions;
        this.answers = answers;
        this.description = description;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blogID != null ? blogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        if ((this.blogID == null && other.blogID != null) || (this.blogID != null && !this.blogID.equals(other.blogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Blog[ blogID=" + blogID + " ]";
    }
    
}
