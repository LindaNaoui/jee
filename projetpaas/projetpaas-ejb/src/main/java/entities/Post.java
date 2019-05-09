package entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Post implements Serializable
{
	public Post(){
		
	}
    public Post(String adDATE, String description, String photo, int userFK, String title, User user) {
		super();
		this.adDATE = adDATE;
		this.description = description;
		this.photo = photo;
		this.userFK = userFK;
		this.title = title;
		this.user = user;
	}

	private String adDATE;

    private String description;

    private String photo;

    private int userFK;

    private String title;

    private  User user;

    private int PostId;

    public String getAdDATE ()
    {
        return adDATE;
    }

    public void setAdDATE (String string)
    {
        this.adDATE = string;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getPhoto ()
    {
        return photo;
    }

    public void setPhoto (String photo)
    {
        this.photo = photo;
    }

    public int getUserFK ()
    {
        return userFK;
    }

    public void setUserFK (int userFK)
    {
        this.userFK = userFK;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    public int getPostId ()
    {
        return PostId;
    }

    public void setPostId (int PostId)
    {
        this.PostId = PostId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [adDATE = "+adDATE+", description = "+description+", photo = "+photo+", userFK = "+userFK+", title = "+title+", user = "+user+", PostId = "+PostId+"]";
    }
}
