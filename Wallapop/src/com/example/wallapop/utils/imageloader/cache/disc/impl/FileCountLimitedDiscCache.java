/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.example.wallapop.utils.imageloader.cache.disc.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;

import com.example.wallapop.utils.imageloader.cache.disc.LimitedDiscCache;
import com.example.wallapop.utils.imageloader.cache.disc.naming.FileNameGenerator;
import com.example.wallapop.utils.imageloader.core.DefaultConfigurationFactory;
import com.example.wallapop.utils.imageloader.utils.IoUtils.CopyListener;

/**
 * Disc cache limited by file count. If file count in cache directory exceeds
 * specified limit then file with the most oldest last usage date will be
 * deleted.
 * 
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @see LimitedDiscCache
 * @since 1.0.0
 */
public class FileCountLimitedDiscCache extends LimitedDiscCache {
	/**
	 * @param cacheDir
	 *            Directory for file caching. <b>Important:</b> Specify separate
	 *            folder for cached files. It's needed for right cache limit
	 *            work.
	 * @param maxFileCount
	 *            Maximum file count for cache. If file count in cache directory
	 *            exceeds this limit then file with the most oldest last usage
	 *            date will be deleted.
	 */
	public FileCountLimitedDiscCache(File cacheDir, int maxFileCount) {
		this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator(),
				maxFileCount);
	}

	/**
	 * @param cacheDir
	 *            Directory for file caching. <b>Important:</b> Specify separate
	 *            folder for cached files. It's needed for right cache limit
	 *            work.
	 * @param fileNameGenerator
	 *            Name generator for cached files
	 * @param maxFileCount
	 *            Maximum file count for cache. If file count in cache directory
	 *            exceeds this limit then file with the most oldest last usage
	 *            date will be deleted.
	 */
	public FileCountLimitedDiscCache(File cacheDir,
			FileNameGenerator fileNameGenerator, int maxFileCount) {
		super(cacheDir, fileNameGenerator, maxFileCount);
	}

	@Override
	protected int getSize(File file) {
		return 1;
	}

	@Override
	public File getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(String imageUri, InputStream imageStream,
			CopyListener listener) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(String imageUri, Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String imageUri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
