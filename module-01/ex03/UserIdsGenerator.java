public class UserIdsGenerator {

	private static UserIdsGenerator instance = new UserIdsGenerator();

    private Integer identifier = 0;

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    public Integer generateId()	{
        this.identifier += 1;
        return this.identifier;
    }

}
