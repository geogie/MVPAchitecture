package com.georgeren.mvpachitecture.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by georgeRen on 2017/9/4.
 */

public class OpenSourceResponse {

    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<Repo> data;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Repo> getData() {
        return data;
    }

    public void setData(List<Repo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenSourceResponse)) return false;

        OpenSourceResponse that = (OpenSourceResponse) o;

        if (!statusCode.equals(that.statusCode)) return false;
        if (!message.equals(that.message)) return false;
        return data != null ? data.equals(that.data) : that.data == null;

    }

    @Override
    public int hashCode() {
        int result = statusCode.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public static class Repo {

        @Expose
        @SerializedName("project_url")
        private String projectUrl;

        @Expose
        @SerializedName("img_url")
        private String coverImgUrl;

        @Expose
        @SerializedName("title")
        private String title;

        @Expose
        @SerializedName("description")
        private String description;

        public String getProjectUrl() {
            return projectUrl;
        }

        public void setProjectUrl(String projectUrl) {
            this.projectUrl = projectUrl;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Repo)) return false;

            Repo repo = (Repo) o;

            if (!projectUrl.equals(repo.projectUrl)) return false;
            if (!coverImgUrl.equals(repo.coverImgUrl)) return false;
            if (!title.equals(repo.title)) return false;
            return description.equals(repo.description);

        }

        @Override
        public int hashCode() {
            int result = projectUrl.hashCode();
            result = 31 * result + coverImgUrl.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + description.hashCode();
            return result;
        }
    }

}
