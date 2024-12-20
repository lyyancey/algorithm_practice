# Created by liuyong at 2024/12/20
*** Settings ***
Documentation     A test suite with a single test for valid login.
...
...               This test has a workflow that is created using keywords in
...               the imported resource file.
Resource          resource.robot

*** Keywords ***
Open Browser To Login Page
    Open Browser    http://172.16.1.89/login    Chrome   options=add_argument("--ignore-certificate-errors")
    Set Selenium Speed    0    # 设置执行完每条Selenium命令之后的等待时间
    Set selenium page load timeout    10 seconds   # 设置页面加载超时（默认是 60 秒）
    Set Browser implicit Wait    10seconds    # 设置隐性等待时间
    Set selenium timeout    10 seconds    # 设置 SeleniumLibrary 的超时时间
    Maximize Browser Window
    Main Page Should Be Open
    Click element    xpath://*[@id="app"]/div[1]/div[1]/div/div[2]/div/button

Main Page Should Be Open
    Title Should Be    HiIT 2.0

Input Username
    [Arguments]    ${username}
    Input Text     name:username  ${username}

Input Password
    [Arguments]    ${password}
    Input Text    name:password    ${password}

Submit Credentials
    Click Button    css:.loginBtn
Click Problem Report
    Wait until element is visible    xpath://*[@id="main-container"]/div[2]/div[1]/div/section/div/div[1]/div[4]/div/div/div/div/div[1]/div/div/div/div/div/div[1]
    Title should be    HiIT 2.0
    Click Element    xpath://*[@id="main-container"]/div[2]/div[1]/div/section/div/div[1]/div[4]/div/div/div/div/div[1]/div

Input Process Title
    Wait until element is visible    xpath://*[@id="main-container"]/div[2]/div[1]/div/section/div/div/div/div[1]/div[1]/div/div[1]/form/div[3]/label
    Input text    xpath://*[@id="main-container"]/div[2]/div[1]/div/section/div/div/div/div[1]/div[1]/div/div[1]/form/div[3]/div/div[1]/div/div/input    如何使用知识库

Select Service Type
    Sleep    2s
    Click element    xpath://*[@id="pane-tab1"]/div/div[2]/div/div/div/div
    Click element    xpath://li[starts-with(@id, 'cascader-menu-') and .//span[@class='el-cascader-node__label' and text()='测试史_暂时勿删']]
    Click element    xpath://li[@role='menuitem' and contains(@id, 'cascader-menu-') and .//span[@class='el-cascader-node__label' and text()='手动新增服务分类']]

Select Business Type
    Press keys    xpath://*[@id="pane-tab1"]/div/div[3]/div/div/div/div/input    手动新增业务分类

Input Location
    Input text    xpath://*[@id="pane-tab1"]/div/div[8]/div/div/div/input   北京市海淀区

Input Description
    Click element    xpath://*[@id="pane-tab1"]/div/div[11]/div/div[1]/div/div[2]/div[1]
    Press keys    xpath://*[@id="pane-tab1"]/div/div[11]/div/div[1]/div/div[2]/div[1]    Test 输入中文，
Click Submit
    Click button    xpath://*[@id="main-container"]/div[2]/div[1]/div/section/div/div/div/div[1]/div[2]/div/div/span/button[3]
*** Test Cases ***
Test Start Process
    Open Browser To Login Page
    Input Username     admin
    Input Password     Itsm123!@#
    Submit Credentials
    Click Problem Report
    Input Process Title
    Select Service Type
    #Select Business Type
    Input Location
    Input Description
    Click Submit
    Wait until location is    http://172.16.1.89/dashboard
    Sleep    5s
    [Teardown]    Close Browser
