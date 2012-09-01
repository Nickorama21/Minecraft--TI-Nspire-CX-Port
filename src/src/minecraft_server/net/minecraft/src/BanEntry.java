package net.minecraft.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class BanEntry
{
    public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

    /** Creates Ban Entry in the logger. */
    public static Logger loggerBanEntry = Logger.getLogger("Minecraft");
    private final String field_73697_c;
    private Date field_73694_d = new Date();
    private String field_73695_e = "(Unknown)";
    private Date field_73692_f = null;
    private String field_73693_g = "Banned by an operator.";

    public BanEntry(String par1Str)
    {
        this.field_73697_c = par1Str;
    }

    public String func_73684_a()
    {
        return this.field_73697_c;
    }

    public Date func_73683_b()
    {
        return this.field_73694_d;
    }

    public void func_73681_a(Date par1Date)
    {
        this.field_73694_d = par1Date != null ? par1Date : new Date();
    }

    public String func_73690_c()
    {
        return this.field_73695_e;
    }

    public void func_73687_a(String par1Str)
    {
        this.field_73695_e = par1Str;
    }

    public Date func_73680_d()
    {
        return this.field_73692_f;
    }

    public void func_73691_b(Date par1Date)
    {
        this.field_73692_f = par1Date;
    }

    public boolean func_73682_e()
    {
        return this.field_73692_f == null ? false : this.field_73692_f.before(new Date());
    }

    public String func_73686_f()
    {
        return this.field_73693_g;
    }

    public void func_73689_b(String par1Str)
    {
        this.field_73693_g = par1Str;
    }

    public String func_73685_g()
    {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.func_73684_a());
        var1.append("|");
        var1.append(field_73698_a.format(this.func_73683_b()));
        var1.append("|");
        var1.append(this.func_73690_c());
        var1.append("|");
        var1.append(this.func_73680_d() == null ? "Forever" : field_73698_a.format(this.func_73680_d()));
        var1.append("|");
        var1.append(this.func_73686_f());
        return var1.toString();
    }

    public static BanEntry func_73688_c(String par0Str)
    {
        if (par0Str.trim().length() < 2)
        {
            return null;
        }
        else
        {
            String[] var1 = par0Str.trim().split(Pattern.quote("|"), 5);
            BanEntry var2 = new BanEntry(var1[0].trim());
            byte var3 = 0;
            int var10000 = var1.length;
            int var7 = var3 + 1;

            if (var10000 <= var7)
            {
                return var2;
            }
            else
            {
                try
                {
                    var2.func_73681_a(field_73698_a.parse(var1[var7].trim()));
                }
                catch (ParseException var6)
                {
                    loggerBanEntry.log(Level.WARNING, "Could not read creation date format for ban entry \'" + var2.func_73684_a() + "\' (was: \'" + var1[var7] + "\')", var6);
                }

                var10000 = var1.length;
                ++var7;

                if (var10000 <= var7)
                {
                    return var2;
                }
                else
                {
                    var2.func_73687_a(var1[var7].trim());
                    var10000 = var1.length;
                    ++var7;

                    if (var10000 <= var7)
                    {
                        return var2;
                    }
                    else
                    {
                        try
                        {
                            String var4 = var1[var7].trim();

                            if (!var4.equalsIgnoreCase("Forever") && var4.length() > 0)
                            {
                                var2.func_73691_b(field_73698_a.parse(var4));
                            }
                        }
                        catch (ParseException var5)
                        {
                            loggerBanEntry.log(Level.WARNING, "Could not read expiry date format for ban entry \'" + var2.func_73684_a() + "\' (was: \'" + var1[var7] + "\')", var5);
                        }

                        var10000 = var1.length;
                        ++var7;

                        if (var10000 <= var7)
                        {
                            return var2;
                        }
                        else
                        {
                            var2.func_73689_b(var1[var7].trim());
                            return var2;
                        }
                    }
                }
            }
        }
    }
}
