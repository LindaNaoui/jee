package entities;
public class Roles
{
    private String UserId;

    private String Id;

    private String RoleId;

    public String getUserId ()
    {
        return UserId;
    }

    public void setUserId (String UserId)
    {
        this.UserId = UserId;
    }

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    public String getRoleId ()
    {
        return RoleId;
    }

    public void setRoleId (String RoleId)
    {
        this.RoleId = RoleId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [UserId = "+UserId+", Id = "+Id+", RoleId = "+RoleId+"]";
    }
}
			