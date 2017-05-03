package functions4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility list functions not found in standard Java.
 *
 * @author Oscar Ahlén
 */
public class ListFunctions
{
    /**
     * Takes a given list of type T and splits it into a number of equally sized sub lists.
     * <br><br>
     * <b>Example:</b>
     * <br>
     * split( [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 4 ) -> [ [1, 2, 3], [4, 5, 6], [7, 8], [9, 10] ]
     * <br><br>
     * <b>Caution:</b><br>
     * This method uses {@link java.util.List#subList(int, int)} for splitting up the original list.
     *
     * @param list  the list to be split
     * @param parts the desired number of sub lists the given list should be split into
     * @param <T>   The list content type
     * @return a list of lists of type T
     * @see java.util.List#subList(int, int)
     */
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

    /**
     * Takes a given list and partitions it into a collection of sub lists of specific size.
     * <br><br>
     * <b>Example:</b>
     * <br>
     * split( [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 4 ) -> [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10] ]
     * <br><br>
     * <b>Caution:</b><br>
     * This method uses {@link java.util.List#subList(int, int)} for partitioning the original list.
     *
     * @param list the list to be partitioned
     * @param size the desired size of the sub list partitions
     * @param <T>  The list content type
     * @return a list of lists of type T
     */
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
