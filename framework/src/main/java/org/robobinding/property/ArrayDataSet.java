package org.robobinding.property;

import org.robobinding.itempresentationmodel.RefreshableItemPresentationModelFactory;


/**
 * @since 1.0
 * @author Cheng Wei
 *
 */
public class ArrayDataSet extends AbstractDataSet {
	public ArrayDataSet(RefreshableItemPresentationModelFactory factory, AbstractGetSet<?> getSet) {
		super(factory, getSet);
	}

	@Override
	public int size() {
		if (isDataSetNull())
			return 0;

		Object[] array = getDataSet();
		return array.length;
	}

	@Override
	public Object getItem(int position) {
		Object[] array = getDataSet();
		return array[position];
	}

}
