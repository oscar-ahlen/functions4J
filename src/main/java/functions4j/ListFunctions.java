package functions4j;

import java.util.ArrayList;
import java.util.List;

public class ListFunctions
{
    public static <T> List<List<T>> split( List<T> list, int parts )
    {
        if ( parts < 1 )
            throw new IllegalArgumentException( "Parts can not be lower than 1" );

        if ( parts > list.size() )
            throw new IllegalArgumentException( "Parts can not be larger than list size" );

        List<List<T>> lists = new ArrayList<>();
        int remainder = list.size() % parts;
        int startIndex = 0;

        for ( int i = 0; i < parts; i++ )
        {
            int endIndex = startIndex + ( list.size() / parts ) + ( remainder-- > 0 ? 1 : 0 );
            lists.add( list.subList( startIndex, endIndex ) );
            startIndex = endIndex;
        }

        return lists;
    }

    public static <T> List<List<T>> partition( List<T> list, int size )
    {
        if ( size < 1 )
            throw new IllegalArgumentException( "Size can not be lower than 1" );

        if ( size > list.size() )
            throw new IllegalArgumentException( "Size can not be larger than list size" );

        List<List<T>> lists = new ArrayList<>();
        int startIndex = 0;

        for ( int i = size; i < list.size(); i += size )
        {
            lists.add( list.subList( startIndex, i ) );
            startIndex = i;
        }

        if ( startIndex < list.size() )
            lists.add( list.subList( startIndex, list.size() ) );

        return lists;
    }
}
