package ru.job4j.dsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicDataSourceTest() {
    @Test
    fun whenSetDriverClassNameAndBuildThenNewBasicDataSourceWithDriverClassName() {
        val ds = BasicDataSource.Builder()
        ds.setDriverClassName("datasource")
        ds.setUrl("some_url")
        ds.setUsername("some_username")
        ds.setPassword("some_password")
        ds.setMinIdle(2)
        ds.setMaxIdle(6)
        ds.setMaxOpenPreparedStatements(10)
        val basicDataSource = ds.build()
        assertThat(basicDataSource.driverClassName).isEqualTo("datasource")
        assertThat(basicDataSource.url).isEqualTo("some_url")
        assertThat(basicDataSource.username).isEqualTo("some_username")
        assertThat(basicDataSource.password).isEqualTo("some_password")
        assertThat(basicDataSource.minIdle).isEqualTo(2)
        assertThat(basicDataSource.maxIdle).isEqualTo(6)
        assertThat(basicDataSource.maxOpenPreparedStatements).isEqualTo(10)
    }

    @Test
    fun whenBuildTwoBasicDataSourceWithSameBuilderThenTheyNotEqual() {
        val ds = BasicDataSource.Builder()
        ds.setDriverClassName("datasource")
        val basicDataSource1 = ds.build()

        val basicDataSource2 = ds.build()

        assertThat(basicDataSource1).isNotEqualTo(basicDataSource2)
    }

    @Test
    fun whenBuildTwoBasicDataSourceWithSameBuilderThenTheirFieldsAreEqual() {
        val ds = BasicDataSource.Builder()
        ds.setDriverClassName("datasource")
        val basicDataSource1 = ds.build()

        val basicDataSource2 = ds.build()

        assertThat(basicDataSource1.driverClassName).isEqualTo(basicDataSource2.driverClassName)
    }

    @Test
    fun whenBuildTwoBasicDataSourceWithNewBuilderThenTheirFieldsAreNotEqual() {
        val ds = BasicDataSource.Builder()
        ds.setDriverClassName("datasource")
        val basicDataSource1 = ds.build()

        val ds2 = BasicDataSource.Builder()
        ds2.setDriverClassName("datasource2")
        val basicDataSource2 = ds2.build()
        assertThat(basicDataSource1.driverClassName).isNotEqualTo(basicDataSource2.driverClassName)
    }
}