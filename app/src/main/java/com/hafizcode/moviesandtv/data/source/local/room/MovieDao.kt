package com.hafizcode.moviesandtv.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hafizcode.moviesandtv.data.entity.MovieEntity
import com.hafizcode.moviesandtv.data.entity.TVEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM tbl_movies")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tbl_tv_show")
    fun getTVs(): LiveData<List<TVEntity>>

    @Query("SELECT * FROM tbl_movies WHERE bookmarked = 1")
    fun getBookmarkedMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tbl_tv_show WHERE bookmarked = 1")
    fun getBookmarkedTVs(): LiveData<List<TVEntity>>

    @Query("SELECT * FROM tbl_movies WHERE id = :id")
    fun getDetailMovie(id: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tbl_tv_show WHERE id = :id")
    fun getDetailTVs(id: String): LiveData<TVEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVs(tvs: List<TVEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTVs(tvs: TVEntity)
}