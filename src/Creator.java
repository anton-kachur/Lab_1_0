import java.util.Random;

abstract class Creator
{
    Random random = new Random();

    protected abstract boolean createMap(MapCreator build);
    protected abstract boolean createMap(MapCreator build, Scale user_scale);

}