import functions4j.ListFunctions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ListFunctionsTest
{
    @Test
    public void testSplit1()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 10; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.split( test, 4 );
        assertEquals( 4, result.size() );
        assertEquals( 3, result.get( 0 ).size() );
        assertEquals( 3, result.get( 1 ).size() );
        assertEquals( 2, result.get( 2 ).size() );
        assertEquals( 2, result.get( 3 ).size() );
    }

    @Test
    public void testSplit2()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 10; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.split( test, 1 );
        assertEquals( 1, result.size() );
        assertEquals( 10, result.get( 0 ).size() );
    }

    @Test
    public void testSplit3()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 1337; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.split( test, 100 );
        assertEquals( 100, result.size() );
        assertEquals( 14, result.get( 0 ).size() );
        assertEquals( 14, result.get( 36 ).size() );
        assertEquals( 13, result.get( 37 ).size() );
        assertEquals( 13, result.get( 99 ).size() );
    }

    @Test
    public void testSplit4()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 1337; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.split( test, 37 );
        assertEquals( 37, result.size() );
        assertEquals( 37, result.get( 0 ).size() );
        assertEquals( 37, result.get( 4 ).size() );
        assertEquals( 36, result.get( 5 ).size() );
        assertEquals( 36, result.get( 36 ).size() );
    }

    @Test
    public void testSplit5()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 1; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.split( test, 1 );
        assertEquals( 1, result.size() );
        assertEquals( 1, result.get( 0 ).size() );
    }

    @Test
    public void testPartition1()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 10; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.partition( test, 3 );
        assertEquals( 4, result.size() );
        assertEquals( 3, result.get( 0 ).size() );
        assertEquals( 3, result.get( 1 ).size() );
        assertEquals( 3, result.get( 2 ).size() );
        assertEquals( 1, result.get( 3 ).size() );
    }

    @Test
    public void testPartition2()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 1337; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.partition( test, 100 );
        assertEquals( 14, result.size() );
        assertEquals( 100, result.get( 0 ).size() );
        assertEquals( 37, result.get( 13 ).size() );
    }

    @Test
    public void testPartition3()
    {
        List<Integer> test = new ArrayList<>();

        for ( int i = 0; i < 1; i++ )
            test.add( i + 1 );

        List<List<Integer>> result = ListFunctions.partition( test, 1 );
        assertEquals( 1, result.size() );
        assertEquals( 1, result.get( 0 ).size() );
    }
}
