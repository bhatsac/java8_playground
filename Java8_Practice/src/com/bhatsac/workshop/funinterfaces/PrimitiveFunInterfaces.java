package com.bhatsac.workshop.funinterfaces;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToLongFunction;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * Since the normal functional Interfaces take a Object type and while passing primitive type auto boxing happens, this is a performance hit
 * So we have primitive Functional interfaces
 * @author bhatsac
 *
 */
public class PrimitiveFunInterfaces {
	
	public static void main(String[] args) {
		
		Predicate<Integer> evenPredicate = i -> i%2==0;
		
		// Here Auto boxing occurs and this is a performance heavy operation.
		System.out.println(evenPredicate.test(7) +" "+evenPredicate.test(4));
		//primitive predicate def
		IntPredicate evenIntPredicate = i -> i%2==0;
		DoublePredicate doublePredicate = d -> d%2.0==0;
		LongPredicate longPredicate = l -> l%2.0==0;
		
		//primitive Supplier def
		IntSupplier intSupplier=null;
		
		//primitive Consumer def
		IntConsumer intConsumer=null;
		
		//primitive Function def
		IntFunction<String> intFunction=null;
		IntToLongFunction intToLongFun=null;
		
		
	}

}
