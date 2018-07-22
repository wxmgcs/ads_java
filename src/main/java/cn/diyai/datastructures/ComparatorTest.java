package cn.diyai.datastructures;

import java.util.*;
import java.util.LinkedList;


class ComparatorTest
{

    private static void sortListOfStringsByLength( List L )
    {
        class Comp implements Comparator
        {
            public int compare( Object lhs, Object rhs )
              { return ((String)lhs).length( ) - ((String)rhs).length( ); }
        }

        Collections.sort( L, new Comp( ) );
    }

    private static void printList( Collection C )
    {
        Iterator itr = C.iterator( );
        while( itr.hasNext( ) )
            System.out.println( itr.next( ) );
    }

    public static void main( String [ ] args )
    {
        LinkedList L = new LinkedList( );
        L.add( "this" );
        L.add( "thank" );
        L.add( "the" );
        sortListOfStringsByLength( L );

        printList( L );
    }
}
