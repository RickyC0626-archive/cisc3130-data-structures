import java.util.*;

public class Question9
{
    protected Map<String, String> passwords;

    public boolean checkPassword(String uname, String psswd)
    {
        String correctPassword = passwords.get(uname);
        if(correctPassword != null) return psswd.equals(correctPassword);
        else passwords.put(uname, psswd);

        return false;
    }
}
