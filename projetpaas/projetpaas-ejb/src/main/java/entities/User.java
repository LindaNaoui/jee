package entities;




                 
public class User
{
    private String birthday;

  

    private String firstname;

    private String img;

    private String role;

    private String Email;

    private String gender;

    private String Address;

    private String[] Meetings;

    private String TeamFK;

    //private null Team;

    private String[] Claims;

    private String[] Tasks;

    private String PhoneNumberConfirmed;

    private String UserName;

    private String pass;

    private String[] Post;

    private Roles[] Roles;

    private String[] Clients;

    private String EmailConfirmed;

    private String lastname;

    private String[] Logins;

    private String AccessFailedCount;

    private String PhoneNumber;


    private String PasswordHash;

    private int Id;

    private String TwoFactorEnabled;

    private String SecurityStamp;

    private String LockoutEnabled;

    public String getBirthday ()
    {
        return birthday;
    }

    public void setBirthday (String birthday)
    {
        this.birthday = birthday;
    }



    public String getFirstname ()
    {
        return firstname;
    }

    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    public String getImg ()
    {
        return img;
    }

    public void setImg (String img)
    {
        this.img = img;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

  


    public String[] getMeetings ()
    {
        return Meetings;
    }

    public void setMeetings (String[] Meetings)
    {
        this.Meetings = Meetings;
    }

    public String getTeamFK ()
    {
        return TeamFK;
    }

  /*  public void setTeamFK (String TeamFK)
    {
        this.TeamFK = TeamFK;
    }

    /*public null getTeam ()
    {
        return Team;
    }

    public void setTeam (null Team)
    {
        this.Team = Team;
    }

    public String[] getClaims ()
    {
        return Claims;
    }

    public void setClaims (String[] Claims)
    {
        this.Claims = Claims;
    }*/

    public String[] getTasks ()
    {
        return Tasks;
    }

    public void setTasks (String[] Tasks)
    {
        this.Tasks = Tasks;
    }

    public String getPhoneNumberConfirmed ()
    {
        return PhoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed (String PhoneNumberConfirmed)
    {
        this.PhoneNumberConfirmed = PhoneNumberConfirmed;
    }

    public String getUserName ()
    {
        return UserName;
    }

    public void setUserName (String UserName)
    {
        this.UserName = UserName;
    }

    public String getPass ()
    {
        return pass;
    }

    public void setPass (String pass)
    {
        this.pass = pass;
    }

    public String[] getPost ()
    {
        return Post;
    }

    public void setPost (String[] Post)
    {
        this.Post = Post;
    }

    public Roles[] getRoles ()
    {
        return Roles;
    }

    public void setRoles (Roles[] Roles)
    {
        this.Roles = Roles;
    }

    public String[] getClients ()
    {
        return Clients;
    }

    public void setClients (String[] Clients)
    {
        this.Clients = Clients;
    }

    public String getEmailConfirmed ()
    {
        return EmailConfirmed;
    }

    public void setEmailConfirmed (String EmailConfirmed)
    {
        this.EmailConfirmed = EmailConfirmed;
    }

    public String getLastname ()
    {
        return lastname;
    }

    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public String[] getLogins ()
    {
        return Logins;
    }

    public void setLogins (String[] Logins)
    {
        this.Logins = Logins;
    }

    public String getAccessFailedCount ()
    {
        return AccessFailedCount;
    }

    public void setAccessFailedCount (String AccessFailedCount)
    {
        this.AccessFailedCount = AccessFailedCount;
    }

    public String getPhoneNumber ()
    {
        return PhoneNumber;
    }

    public void setPhoneNumber (String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }



    public String getPasswordHash ()
    {
        return PasswordHash;
    }

    public void setPasswordHash (String PasswordHash)
    {
        this.PasswordHash = PasswordHash;
    }

    public int getId ()
    {
        return Id;
    }

    public void setId (int Id)
    {
        this.Id = Id;
    }

    public String getTwoFactorEnabled ()
    {
        return TwoFactorEnabled;
    }

    public void setTwoFactorEnabled (String TwoFactorEnabled)
    {
        this.TwoFactorEnabled = TwoFactorEnabled;
    }

    public String getSecurityStamp ()
    {
        return SecurityStamp;
    }

    public void setSecurityStamp (String SecurityStamp)
    {
        this.SecurityStamp = SecurityStamp;
    }

    public String getLockoutEnabled ()
    {
        return LockoutEnabled;
    }

    public void setLockoutEnabled (String LockoutEnabled)
    {
        this.LockoutEnabled = LockoutEnabled;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [birthday = "+birthday+", firstname = "+firstname+",role="+role+", img = "+img+", Email = "+Email+", gender = "+gender+", Address = "+Address+", Meetings = "+Meetings+", TeamFK = "+TeamFK+", Claims = "+Claims+", Tasks = "+Tasks+", PhoneNumberConfirmed = "+PhoneNumberConfirmed+", UserName = "+UserName+", pass = "+pass+", Post = "+Post+", Clients = "+Clients+", EmailConfirmed = "+EmailConfirmed+", lastname = "+lastname+", Logins = "+Logins+", AccessFailedCount = "+AccessFailedCount+", PhoneNumber = "+PhoneNumber+", PasswordHash = "+PasswordHash+", Id = "+Id+", TwoFactorEnabled = "+TwoFactorEnabled+", SecurityStamp = "+SecurityStamp+", LockoutEnabled = "+LockoutEnabled+"]";
    }
}
			
			


